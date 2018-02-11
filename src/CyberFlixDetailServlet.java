import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.txstate.cyberflix.data.db.FilmDAO;
import edu.txstate.internet.cyberflix.data.actor.Actor;
import edu.txstate.internet.cyberflix.data.film.Film;
import edu.txstate.internet.cyberflix.data.film.FilmCatalog;

/**
 * Servlet implementation class CyberFlixDetailServlet
 */
@WebServlet("/CyberFlixDetailServlet")
public class CyberFlixDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CyberFlixDetailServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String t = (String) request.getAttribute("text");
		String parameter = request.getParameter("film_title");
		System.out.println("film title: " + parameter);
		FilmCatalog catalog = FilmCatalog.getInstance();
		// int filmID = Integer.parseInt(parameter);
		// FilmActorReader fAR = new FilmActorReader();
		// List<Integer> actorIDs = new ArrayList<Integer>();
		FilmDAO fd = new FilmDAO();
		List<Film> film1 = fd.findFilmsByAttributes(parameter, "", -1, null);
		System.out.print("Film1: " + film1);
		Film thisFilm = fd.getFilmDetail(film1.get(0));
		List<Actor> allActors = fd.findActorsInFilm(thisFilm); // (film1.get(0));
		// ActorReader ar = new ActorReader();
		// allActors = ar.readActorFile(ServletUtils.getProjectInputFilesPath(),
		// "actors.csv");
		// List<SimpleEntry<Integer, Integer>> filmActorPairs = new
		// ArrayList<SimpleEntry<Integer, Integer>>();
		// filmActorPairs =
		// fAR.readFilmActorFile(ServletUtils.getProjectInputFilesPath(),
		// "film_actors.csv");
		//
		// Film film = catalog.get(filmID);
		// System.out.println(film);
		//
		// for (int i = 0; i < filmActorPairs.size(); i++)
		// {
		// if (filmActorPairs.get(i).getKey().equals(filmID))
		// {
		// actorIDs.add(filmActorPairs.get(i).getValue());
		// }
		// }
		//
		// List<Actor> actors = new ArrayList<Actor>();
		//
		//
		// ActorInventory ai = ActorInventory.getInstance();
		// ai.addAll(allActors);
		//
		// for (int i = 0; i < actorIDs.size(); i++)
		// {
		// actors.add(ai.get(actorIDs.get(i)));
		// }
		//
		// System.out.println("Actors: " + actors);

		request.setAttribute("film", thisFilm);
		request.setAttribute("actors", allActors);
		request.getRequestDispatcher("movieDetails.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
