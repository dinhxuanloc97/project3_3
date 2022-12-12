package ra.controller;

import ra.model.entity.Cart;
import ra.model.entity.Product;
import ra.model.entity.WishList;
import ra.model.service.ProductSevice;
import ra.model.serviceImp.ProductServiceImp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "WishlistServlet", value = "/WishlistServlet")
public class WishlistServlet extends HttpServlet {

    private ProductSevice<Product,String> productSevice = new ProductServiceImp();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action.equals("AddWish")) {
            String productId = request.getParameter("productId");
            //goi vao db lay thong tin san pham mua

            Product proAdd = productSevice.findById(productId);

            //2. Lấy giỏ hàng từ session (Mặc định tên giỏ hàng trong session là listCart)
            HttpSession session = request.getSession();
            List<WishList> listWish = (List<WishList>) session.getAttribute("listWish");
            //3. Kiểm tra listCart
            if (listWish == null) {
                //Khách hàng chưa mua hàng
                //-Khởi tạo giỏ hàng
                listWish = new ArrayList<>();
                //-add cart vao listCart
                WishList wishList = new WishList(proAdd, 1);
                listWish.add(wishList);
            } else {
                //Khách hàng đã mua hàng
                //-Kiem tra san pham da ton tai trong gio hang cua khach hang chua
                boolean checkExist = false;
                for (WishList wish : listWish) {
                    if (wish.getProduct().getProductId().equals(productId)) {
                        //Sản phẩm thêm vào giỏ hàng đã tồn tại trong giỏ hàng
                        wish.setQuantity(wish.getQuantity() + 1);
                        checkExist = true;
                        break;
                    }
                }
                if (!checkExist) {
                    //Sản phẩm thêm chưa có trong giỏ hàng
                    WishList wishList = new WishList(proAdd, 1);
                    listWish.add(wishList);
                }
            }
            //4. add listCart vao session
            session.setAttribute("listWish", listWish);
            //5. Tinh tong tien va add vao session
//            session.setAttribute("totalAmount", calTotalAmount(listCart));
            //6. Chuyen sang trang shopping cart
            request.getRequestDispatcher("views/user/wishlist.jsp").forward(request, response);
        }else if (action.equals("Delete")) {
            List<WishList> wishLists = (List<WishList>) request.getSession().getAttribute("listWish");
            String productId = request.getParameter("productId");
            for (int i = 0; i < wishLists.size(); i++) {
                if (wishLists.get(i).getProduct().getProductId().equals(productId)){
                    wishLists.remove(i);
                }
            }
            request.getSession().setAttribute("listWish",wishLists);
//            request.getSession().setAttribute("totalAmount",calTotalAmount(listCart));
            request.getRequestDispatcher("views/user/wishlist.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
