package rocaplan.controladores;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.StringReader;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rocaplan.dao.ProdutoDAO;
import rocaplan.dao.ProdutoVendidoDAO;
import rocaplan.dao.UsuarioDAO;
import rocaplan.dao.VendaDAO;
import rocaplan.entidades.Produto;
import rocaplan.entidades.ProdutoVendido;
import rocaplan.entidades.Usuario;
import rocaplan.entidades.Venda;
import rocaplan.utils.Utils;

@WebServlet(name = "VendaServlet", urlPatterns = {"/VendaServlet"})
public class VendaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        Jsonb jb = JsonbBuilder.create();

        try (VendaDAO daoVenda = new VendaDAO(); ProdutoVendidoDAO daoProdutoVendido = new ProdutoVendidoDAO(); UsuarioDAO daoUsuario = new UsuarioDAO(); ProdutoDAO daoProduto = new ProdutoDAO()) {

            if (acao.equals("inserir")) {

                String venNomeCliente = request.getParameter("venNomeCliente");
                String venData = request.getParameter("venData");
                boolean venSituacaoPagamento = Boolean.parseBoolean(request.getParameter("venSituacaoPagamento"));
                String produtos = request.getParameter("produtos");
                Long usuId = Utils.getLong(request, "usuId");

                JsonReader jsr = Json.createReader(new StringReader(produtos));
                JsonArray jsaProdutos = jsr.readArray();

                Usuario u = daoUsuario.obterPorId(usuId);

                Venda v = new Venda();
                v.setUsuario(u);
                v.setVenData(Utils.getDate(venData));
                v.setVenNomeCliente(venNomeCliente);
                v.setVenSituacaoPagamento(venSituacaoPagamento);

                Utils.validar(v, "venId");
                daoVenda.salvar(v);
                
                BigDecimal venValorTotal = BigDecimal.ZERO;

                for (JsonValue jsv : jsaProdutos) {

                    JsonObject jso = jsv.asJsonObject();

                    Long proId = Utils.getLong(jso.getString("proId"));
                    BigDecimal prvQuantidade = Utils.getBigDecimal(jso.getString("prvQuantidade"));                    

                    // obtém o produto e atualiza o estoque
                    Produto p = daoProduto.obterPorId(proId);
                    p.setProQuantidade(p.getProQuantidade().subtract(prvQuantidade));
                    venValorTotal = venValorTotal.add(prvQuantidade.multiply(p.getProValorUnitario()));

                    ProdutoVendido pv = new ProdutoVendido();
                    pv.setProduto(p);
                    pv.setVenda(v);
                    pv.setPrvQuantidade(prvQuantidade);

                    daoProduto.atualizar(p);
                    daoProdutoVendido.salvar(pv);

                }
                
                v.setVenValorTotal(venValorTotal);
                daoVenda.atualizar(v);

            } else if (acao.equals("alterar")) {

            } else if (acao.equals("excluir")) {

            } else if (acao.equals("listar")) {

                int pagina = Integer.parseInt(request.getParameter("pagina"));
                List<Venda> vendas = daoVenda.listarComPaginacao(pagina - 1);
                int totalVendas = daoVenda.totalVendas();
                
                Map<String, Object> responseMap = new HashMap<>();
                responseMap.put("vendas", vendas);
                responseMap.put("totalVendas", totalVendas);
                

                try (PrintWriter out = response.getWriter()) {
                    out.print(jb.toJson(responseMap));
                }
                
            } else if (acao.equals("filtrar")) {

            } else {
                // Preparar Alteração
            }

        } catch (SQLException exc) {
            // Retornando o erro como Json, porque a requisição vai vir de um Modal por Js
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);

            try (PrintWriter out = response.getWriter()) {
                out.print(jb.toJson(exc.getMessage()));
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
