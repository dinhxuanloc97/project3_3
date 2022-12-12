package ra.controller;
import ra.model.entity.Catalog;
import ra.model.entity.Product;
import ra.model.entity.User;
import ra.model.service.CatalogService;
import ra.model.service.ProductSevice;
import ra.model.service.UserServices;
import ra.model.serviceImp.CatalogServiceImp;
import ra.model.serviceImp.ProductServiceImp;
import ra.model.serviceImp.UserSevicesImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private  ProductSevice<Product,String> productSeviceImp = new ProductServiceImp();
    private UserServices userService = new UserSevicesImp();
    private CatalogService<Catalog,Integer> catalogService = new CatalogServiceImp();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equals("GetAll")) {
            getAllUser(request, response);
        }else if (action.equals("Unlock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean unlock = userService.unlockUser(userId);
            if (unlock) {
                getAllUser(request,response);
            }
        } else if (action.equals("Lock")) {
            int userId = Integer.parseInt(request.getParameter("userId"));
            boolean lock = userService.lockUser(userId);
            if (lock) {
                getAllUser(request,response);
            }
        } else if (action!=null&&action.equals("logOut")) {
            HttpSession session = request.getSession();
            session.removeAttribute("userLogin");
            request.setAttribute("listPro",productSeviceImp.findAll());
            List<Catalog> listCatalog = catalogService.findAll();
            request.setAttribute("listCat",listCatalog);
            request.getRequestDispatcher("views/user/index.jsp").forward(request,response);
        } else if (action!=null&&action.equals("Search")) {
            String prName = request.getParameter("searchName");
            request.setAttribute("listUser", userService.searchByName(prName));
            request.getRequestDispatcher("views/admin/user.jsp").forward(request,response);

        }
        getAllUser(request,response);
    }
    public void getAllUser (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> listUser = userService.findAll();
        request.setAttribute("listUser", listUser);
        request.getRequestDispatcher("views/admin/user.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action.equalsIgnoreCase("register")){
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            String phonenumber = request.getParameter("phoneNumber");
            String fullName = request.getParameter("fullName");
            User user = new User();
            user.setUserName(userName);
            user.setPassword(password);
            user.setPhoneNumber(phonenumber);
            user.setFullName(fullName);
            boolean checkExit = userService.register(user);
            if (checkExit){
                request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
            }
            } else if (action.equalsIgnoreCase("login")) {
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            User user = userService.login(userName,password);
            if(user.getUserName()==null){
                request.setAttribute("errorLogin","Tài khoản hoặc mật khẩu của bạn  không chính xác");
                request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
            }
            if (user!=null){
                HttpSession session = request.getSession();
                session.setAttribute("userLogin",user);
                if (user.isPermisson()){
                    request.getRequestDispatcher("views/admin/index.jsp").forward(request, response);
                } else {
                    if (user.isUserStatus()) {
                        List<Product> listPro= productSeviceImp.getSpecialProduct();
                        request.setAttribute("listPro",listPro);
                        request.getRequestDispatcher("views/user/index.jsp").forward(request, response);
                    } else {
                        request.setAttribute("errorLogin","Tài khoản tạm khóa ");
                        request.getRequestDispatcher("views/user/login.jsp").forward(request,response);
                    }
                }
            }else  {
                request.getRequestDispatcher("views/user/login.jsp").forward(request, response);
            }
        }
    }
}