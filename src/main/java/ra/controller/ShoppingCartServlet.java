package ra.controller;

import ra.model.entity.Cart;
import ra.model.entity.Product;
import ra.model.service.ProductSevice;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShoppingCartServlet", value = "/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
    private ProductSevice<Product,String> productSevice = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals("AddCart")) {
            String productId = request.getParameter("productId");
            //goi vao db lay thong tin san pham mua

            Product proAdd = productSevice.findById(productId);

            //2. Lấy giỏ hàng từ session (Mặc định tên giỏ hàng trong session là listCart)
            HttpSession session = request.getSession();
            List<Cart> listCart = (List<Cart>) session.getAttribute("listCart");
            //3. Kiểm tra listCart
            if (listCart == null) {
                //Khách hàng chưa mua hàng
                //-Khởi tạo giỏ hàng
                listCart = new ArrayList<>();
                //-add cart vao listCart
                Cart cart = new Cart(proAdd, 1);
                listCart.add(cart);
            } else {
                //Khách hàng đã mua hàng
                //-Kiem tra san pham da ton tai trong gio hang cua khach hang chua
                boolean checkExist = false;
                for (Cart cart : listCart) {
                    if (cart.getProduct().getProductId().equals(productId)) {
                        //Sản phẩm thêm vào giỏ hàng đã tồn tại trong giỏ hàng
                        cart.setQuantity(cart.getQuantity() + 1);
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    //Sản phẩm thêm chưa có trong giỏ hàng
                    Cart cart = new Cart(proAdd, 1);
                    listCart.add(cart);
                }
            }
            //4. add listCart vao session
            session.setAttribute("listCart", listCart);
            //5. Tinh tong tien va add vao session
            session.setAttribute("totalAmount", calTotalAmount(listCart));
            //6. Chuyen sang trang shopping cart
            request.getRequestDispatcher("views/user/cart.jsp").forward(request, response);
        }else if (action.equals("Delete")) {
            List<Cart> listCart = (List<Cart>) request.getSession().getAttribute("listCart");
            String productId = request.getParameter("productId");
            for (int i = 0; i < listCart.size(); i++) {
                if (listCart.get(i).getProduct().getProductId().equals(productId)){
                    listCart.remove(i);
                }
            }
            request.getSession().setAttribute("listCart",listCart);
            request.getSession().setAttribute("totalAmount",calTotalAmount(listCart));
            request.getRequestDispatcher("views/user/cart.jsp").forward(request,response);
        }
    }

    public static float calTotalAmount(List<Cart> listCart) {
        float totalAmount = 0;
        for (Cart cart : listCart) {
            totalAmount += cart.getQuantity() * cart.getProduct().getPrice();
        }
        return totalAmount;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
