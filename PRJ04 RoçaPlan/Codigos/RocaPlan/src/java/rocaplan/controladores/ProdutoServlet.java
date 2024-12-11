package rocaplan.controladores;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import java.sql.SQLException;
import rocaplan.dao.ProdutoDAO;
import rocaplan.entidades.Produto;
import rocaplan.entidades.Usuario;
import rocaplan.entidades.TipoProduto;

@WebServlet(urlPatterns = {"/ProdutoServlet"})
public class ProdutoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String acao = request.getParameter( "acao" );
        ProdutoDAO dao = null;
        RequestDispatcher disp = null;
        Jsonb jb = JsonbBuilder.create();
        
        try {

            dao = new ProdutoDAO();

            if ( acao.equals( "inserir" ) ) {

                String proNome = request.getParameter("proNome");
                int proQuantidade = Integer.parseInt(request.getParameter("proQuantidade"));
                float proValorUnitario = Float.parseFloat(request.getParameter("proValorUnitario"));
                int fkUsuId = Integer.parseInt(request.getParameter("fkUsuId"));
                int fkTprId = Integer.parseInt(request.getParameter("fkTprId"));
                
                Usuario u = new Usuario();
                u.setUsuId(fkUsuId);
                
                TipoProduto tp = new TipoProduto();
                tp.setTprId(fkTprId);

                Produto p = new Produto();
                p.setProNome(proNome);
                p.setProQuantidade(proQuantidade);
                p.setProValorUnitario(proValorUnitario);
                p.setUsuario(u);
                p.setTipoProduto(tp);
                
                dao.salvar(p);

                disp = request.getRequestDispatcher(
                        "/pages/products.jsp" );

            } else if ( acao.equals( "alterar" ) ) {

                int id = Integer.parseInt(request.getParameter("id"));
                String proNome = request.getParameter("nome");
                int proQuantidade = Integer.parseInt(request.getParameter("quantidade"));
                float proValorUnitario = Float.parseFloat(request.getParameter("valorUnitario"));
                int fkUsuId = 1; // teria que pegar da sessão do login
                int fkTprId = Integer.parseInt(request.getParameter("type"));

                Usuario u = new Usuario();
                u.setUsuId(fkUsuId);
                
                TipoProduto tp = new TipoProduto();
                tp.setTprId(fkTprId);

                Produto p = new Produto();
                p.setProNome(proNome);
                p.setProQuantidade(proQuantidade);
                p.setProValorUnitario(proValorUnitario);
                p.setUsuario(u);
                p.setTipoProduto(tp);
                p.setProId(id);

                dao.atualizar(p);

                disp = request.getRequestDispatcher(
                        "/pages/products.jsp" );              

            } else if ( acao.equals( "excluir" ) ) {

                int id = Integer.parseInt(request.getParameter("id"));

                Produto p = new Produto();
                p.setProId(id);

                dao.excluir(p);

                disp = request.getRequestDispatcher(
                        "/pages/products.jsp" );

            } else if( acao.equals( "listar" ) ) {
                List<Produto> produtos = dao.listarTodos();
                
                try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( produtos ) );
                }
            } else {
                // Preparar Alteração
                int id = Integer.parseInt(request.getParameter("id"));
                Produto p = dao.obterPorId(id);
                
                try ( PrintWriter out = response.getWriter() ) {
                    out.print( jb.toJson( p ) );
                }
                
            }

        } catch ( SQLException exc ) {
            exc.printStackTrace();
        } finally {
            if ( dao != null ) {
                try {
                    dao.fecharConexao();
                } catch ( SQLException exc ) {
                    exc.printStackTrace();
                }
            }
        }

        if ( disp != null ) {
            disp.forward( request, response );
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
