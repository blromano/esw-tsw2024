package conecta.controladores;

import conecta.dao.AgendamentoDAO;
import conecta.entidades.Agendamento;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "AgendamentoServlet", urlPatterns = {"/processaAgendamento"})
public class AgendamentoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");
        AgendamentoDAO dao = null;
        RequestDispatcher disp = null;

        try {
            dao = new AgendamentoDAO();

            if (acao.equals("inserir")) {
                Date age_data = Date.valueOf(request.getParameter("age_data"));
                Time age_horario = Time.valueOf(request.getParameter("age_horario"));
                String age_status = request.getParameter("age_status");

                Agendamento agendamento = new Agendamento();
                agendamento.setAge_data(age_data);
                agendamento.setAge_horario(age_horario);
                agendamento.setAge_status(age_status);

                dao.salvar(agendamento);
                disp = request.getRequestDispatcher("/formularios/agendamentos/listagem.jsp");

            } else if (acao.equals("alterar")) {
                int id = Integer.parseInt(request.getParameter("id"));
                Date age_data = Date.valueOf(request.getParameter("age_data"));
                Time age_horario = Time.valueOf(request.getParameter("age_horario"));
                String age_status = request.getParameter("age_status");

                Agendamento agendamento = new Agendamento();
                agendamento.setId_agendamentos(id);
                agendamento.setAge_data(age_data);
                agendamento.setAge_horario(age_horario);
                agendamento.setAge_status(age_status);

                dao.atualizar(agendamento);
                disp = request.getRequestDispatcher("/formularios/agendamentos/listagem.jsp");

            } else if (acao.equals("excluir")) {
                int id = Integer.parseInt(request.getParameter("id"));

                Agendamento agendamento = new Agendamento();
                agendamento.setId_agendamentos(id);
                dao.excluir(agendamento);
                disp = request.getRequestDispatcher("/formularios/agendamentos/listagem.jsp");

            } else {
                Long id = Long.parseLong(request.getParameter("id")); // Alterado de int para Long
                Agendamento agendamento = dao.obterPorId(id);
                request.setAttribute("agendamento", agendamento);

                if (acao.equals("prepararAlteracao")) {
                    disp = request.getRequestDispatcher("/formularios/agendamentos/alterar.jsp");
                } else if (acao.equals("prepararExclusao")) {
                    disp = request.getRequestDispatcher("/formularios/agendamentos/excluir.jsp");
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
        return "AgendamentoServlet";
    }
}
