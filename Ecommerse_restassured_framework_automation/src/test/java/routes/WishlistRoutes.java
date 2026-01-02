package routes;

public class WishlistRoutes 
{
    String globalBackendRoute = "http://localhost:3010";

    // READ: Get current user's wishlist
    String get_wishlist_route                     = globalBackendRoute + "/api/get-wishlist";

    // CREATE: Add item to wishlist
    String post_add_to_wishlist_route             = globalBackendRoute + "/api/add-to-wishlist";

    // DELETE: Remove item from wishlist (append productId)
    String delete_remove_from_wishlist_route      = globalBackendRoute + "/api/remove-from-wishlist/";    // + {productId}

    // PATCH: Toggle save-for-later (append productId)
    String patch_toggle_save_for_later_route      = globalBackendRoute + "/api/toggle-save-for-later/";   // + {productId}

    // POST: Move items from wishlist to cart
    String post_move_to_cart_route                = globalBackendRoute + "/api/move-to-cart";
}
