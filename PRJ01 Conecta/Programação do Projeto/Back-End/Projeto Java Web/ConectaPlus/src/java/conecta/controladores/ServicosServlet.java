package conecta.controladores;

import conecta.dao.ServicosDAO;
import conecta.entidades.Servicos;
import java.io.IOException;
import java.sql.SQLException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "ServicosServlet", urlPatterns = {"/processaServicos"})
public class ServicosServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        ServicosDAO dao = null;
        RequestDispatcher disp = null;

        try {
            dao = new ServicosDAO();

            if (acao.equals("inserir")) {
                String nome = request.getParameter("nome");
                String area = request.getParameter("area");
                String descricao = request.getParameter("descricao");

                Servicos servicos = new Servicos();
                servicos.setSer_nome(nome);
                servicos.setSer_area(area);
                servicos.setSer_descricao(descricao);

                dao.salvar(servicos);
                disp = request.getRequestDispatcher("/formularios/servicos/listagemS.jsp");

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                String nome = request.getParameter("nome");
                String area = request.getParameter("area");
                String descricao = request.getParameter("descricao");

                Servicos servicos = new Servicos();
                servicos.setId_servicos(id);
                servicos.setSer_nome(nome);
                servicos.setSer_area(area);
                servicos.setSer_descricao(descricao);

                dao.atualizar(servicos);
                disp = request.getRequestDispatcher("/formularios/servicos/listagemS.jsp");

            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));

                Servicos servicos = new Servicos();
                servicos.setId_servicos(id);
                dao.excluir(servicos);
                disp = request.getRequestDispatcher("/formularios/servicos/listagemS.jsp");

            } else {
                int id = Integer.parseInt(request.getParameter("id"));
                Servicos servicos = dao.obterPorId(id);
                request.setAttribute("servicos", servicos);

                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher("/formularios/servicos/alterar.jsp");
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher("/formularios/servicos/excluir.jsp");
                }
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        } finally {
            if (dao != null) {
                try {
                    dao.fecharConexao();
                } catch (SQLException exc) {
                    exc.printStackTrace();
                }
            }
        }

        if (disp != null) {
            disp.forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "ServicosServlet";
    }
}
