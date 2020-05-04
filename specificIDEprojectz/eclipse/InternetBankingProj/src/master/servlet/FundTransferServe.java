package master.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import master.DAO.AccountDAO;
import master.DAO.FundTransferDAO;
import master.DTO.FundTransferDTO;


/**
 * Servlet implementation class FundTransferServe
 */
public class FundTransferServe extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		
		String saccno=request.getParameter("saccno");
		String baccno=request.getParameter("baccno");
		String ifcs=request.getParameter("ifcs");
		String bank=request.getParameter("bank");
		double amount=Double.parseDouble(request.getParameter("amount"));
		String tdate=request.getParameter("tdate");
		
		/**validation with insert data*/
		
		AccountDAO adao=new AccountDAO();
		
		if(!adao.checkAccount(saccno)) {
			
			response.sendRedirect("InvalidSourceAccount.jsp");
			
		} else if(!adao.checkAccount(baccno)) {
			
			response.sendRedirect("InvalidBeneficiaryAccount.jsp");
			
		} else if(adao.getBalance(saccno)<amount) {
			
			response.sendRedirect("InsufficientBalance.jsp");
			
		} else {
			
			FundTransferDTO ftdto=new FundTransferDTO();

			ftdto.setSaccno(saccno);
			ftdto.setBaccno(baccno);
			ftdto.setIfcs(ifcs);
			ftdto.setBank(bank);
			ftdto.setAmount(amount);
			ftdto.setTdate(tdate);
			
			FundTransferDAO ftdao=new FundTransferDAO();
			
			ftdao.insertData(ftdto);
			
			response.sendRedirect("FundTransferSuccess.jsp");
			
		}
	}

}
