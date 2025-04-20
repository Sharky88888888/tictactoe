import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class GameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Game game = (Game) session.getAttribute("game");

        if (game == null) {
            game = new Game();
            session.setAttribute("game", game);
        }

        String cellParam = request.getParameter("cell");
        if (cellParam != null) {
            int cell = Integer.parseInt(cellParam);
            game.makeMove(cell);
        }

        request.setAttribute("board", game.getBoard());

        char winner = game.checkWinner();
        if (winner != ' ') {
            request.setAttribute("message", "Winner: " + winner);
            session.removeAttribute("game");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }
}
