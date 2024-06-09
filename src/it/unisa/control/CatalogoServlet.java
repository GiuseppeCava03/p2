package it.unisa.control;

import java.io.IOException; 
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.ProdottoBean;
import it.unisa.model.ProdottoDao;

@WebServlet("/catalogo")
private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

private static final long serialVersionUID = 1L;
public class CatalogoServlet extends HttpServlet {
	
	 ProdottoDao prodDao = new ProdottoDao();
     ProdottoBean bean = new ProdottoBean();
     String sort = sanitize(request.getParameter("sort"));
     String action = sanitize(request.getParameter("action"));
     String redirectedPage = request.getParameter("page");

     try {
         if(action != null) {
             if(action.equalsIgnoreCase("add")) {
                 bean.setNome(sanitize(request.getParameter("nome")));
                 bean.setDescrizione(sanitize(request.getParameter("descrizione")));
                 bean.setIva(sanitize(request.getParameter("iva")));
                 bean.setPrezzo(Double.parseDouble(sanitize(request.getParameter("prezzo"))));
                 bean.setQuantit�(Integer.parseInt(sanitize(request.getParameter("quantit�"))));
                 bean.setPiattaforma(sanitize(request.getParameter("piattaforma")));
                 bean.setGenere(sanitize(request.getParameter("genere")));
                 bean.setImmagine(sanitize(request.getParameter("img")));
                 bean.setDataUscita(sanitize(request.getParameter("dataUscita")));
                 bean.setDescrizioneDettagliata(sanitize(request.getParameter("descDett")));
                 bean.setInVendita(true);
                 prodDao.doSave(bean);
             } else if(action.equalsIgnoreCase("modifica")) {
                 bean.setIdProdotto(Integer.parseInt(sanitize(request.getParameter("id"))));
                 bean.setNome(sanitize(request.getParameter("nome")));
                 bean.setDescrizione(sanitize(request.getParameter("descrizione")));
                 bean.setIva(sanitize(request.getParameter("iva")));
                 bean.setPrezzo(Double.parseDouble(sanitize(request.getParameter("prezzo"))));
                 bean.setQuantit�(Integer.parseInt(sanitize(request.getParameter("quantit�"))));
                 bean.setPiattaforma(sanitize(request.getParameter("piattaforma")));
                 bean.setGenere(sanitize(request.getParameter("genere")));
                 bean.setImmagine(sanitize(request.getParameter("img")));
                 bean.setDataUscita(sanitize(request.getParameter("dataUscita")));
                 bean.setDescrizioneDettagliata(sanitize(request.getParameter("descDett")));
                 bean.setInVendita(true);
                 prodDao.doUpdate(bean);    
             }

	private static final long serialVersionUID = 1L;

	
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			}
			
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}


		try {
			request.getSession().removeAttribute("products");
			request.getSession().setAttribute("products", prodDao.doRetrieveAll(sort));
		} catch (SQLException e) {
			System.out.println("Error:" + e.getMessage());
		}
		
			
			response.sendRedirect(request.getContextPath() + "/" +redirectedPage);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
