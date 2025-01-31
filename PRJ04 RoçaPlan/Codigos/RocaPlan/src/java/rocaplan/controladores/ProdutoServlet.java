package rocaplan.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.List;
import java.sql.SQLException;
import rocaplan.dao.ProdutoDAO;
import rocaplan.dao.TipoProdutoDAO;
import rocaplan.entidades.Produto;
import rocaplan.entidades.Usuario;
import rocaplan.entidades.TipoProduto;
import rocaplan.utils.Utils;

@WebServlet(name = "ProdutoServlet", urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        Jsonb jb = JsonbBuilder.create();

        try (ProdutoDAO daoProduto = new ProdutoDAO(); TipoProdutoDAO daoTipoProduto = new TipoProdutoDAO()) {

            if (acao.equals("inserir")) {

                String proNome = request.getParameter("proNome");
                BigDecimal proQuantidade = Utils.getBigDecimal(request.getParameter("proQuantidade"));
                BigDecimal proValorUnitario = Utils.getBigDecimal(request.getParameter("proValorUnitario"));
                Long usuId = Utils.getLong(request, "usuId");
                Long tprId = Utils.getLong(request, "tprId");
                String newTpr = request.getParameter("newTpr");

                TipoProduto tp = new TipoProduto();

                if (!newTpr.isEmpty()) {
                    tp.setTprNome(newTpr);
                    Utils.validar(tp, "tprId");
                    daoTipoProduto.salvar(tp);
                } else {
                    tp.setTprId(tprId);
                }

                Usuario u = new Usuario();
                u.setUsuId(usuId);

                Produto p = new Produto();
                p.setProNome(proNome);
                p.setProQuantidade(proQuantidade);
                p.setProValorUnitario(proValorUnitario);
                p.setUsuario(u);
                p.setTipoProduto(tp);

                Utils.validar(p, "proId");
                daoProduto.salvar(p);

            } else if (acao.equals("alterar")) {

                Long id = Utils.getLong(request, "proId");
                String proNome = request.getParameter("proNome");
                BigDecimal proQuantidade = Utils.getBigDecimal(request.getParameter("proQuantidade"));
                BigDecimal proValorUnitario = Utils.getBigDecimal(request.getParameter("proValorUnitario"));
                Long usuId = Utils.getLong(request, "usuId");
                Long tprId = Utils.getLong(request, "tprId");
                String newTpr = request.getParameter("newTpr");

                Usuario u = new Usuario();
                u.setUsuId(usuId);

                TipoProduto tp = new TipoProduto();

                if (!newTpr.isEmpty()) {
                    tp.setTprNome(newTpr);
                    Utils.validar(tp, "tprId");
                    daoTipoProduto.salvar(tp);
                } else {
                    tp.setTprId(tprId);
                }

                Produto p = new Produto();
                p.setProNome(proNome);
                p.setProQuantidade(proQuantidade);
                p.setProValorUnitario(proValorUnitario);
                p.setUsuario(u);
                p.setTipoProduto(tp);
                p.setProId(id);

                Utils.validar(p);
                daoProduto.atualizar(p);

            } else if (acao.equals("excluir")) {

                Long id = Utils.getLong(request, "proId");

                Produto p = new Produto();
                p.setProId(id);

                daoProduto.excluir(p);

            } else if (acao.equals("listar")) {
                List<Produto> produtos = daoProduto.listarTodos();

                try (PrintWriter out = response.getWriter()) {
                    out.print(jb.toJson(produtos));
                }
            } else {
                // Preparar Alteração
                Long id = Utils.getLong(request, "proId");
                Produto p = daoProduto.obterPorId(id);

                try (PrintWriter out = response.getWriter()) {
                    out.print(jb.toJson(p));
                }

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
