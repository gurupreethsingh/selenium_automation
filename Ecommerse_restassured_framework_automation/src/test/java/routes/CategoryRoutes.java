package routes;

public class CategoryRoutes 
{
    String globalBackendRoute = "http://localhost:3010";

    // CREATE
    String post_add_category_route = globalBackendRoute + "/api/add-category";

    // READ
    String get_fetch_all_categories_route      = globalBackendRoute + "/api/all-categories";
    String get_category_count_route            = globalBackendRoute + "/api/category-count";
    String get_category_product_counts_route   = globalBackendRoute + "/api/category-product-counts";
    
    // For these, append the category ID where you use them:
    String get_single_category_route           = globalBackendRoute + "/api/single-category/";   // + {id}

    // UPDATE (append :id)
    String put_update_category_route           = globalBackendRoute + "/api/update-category/";   // + {id}

    // DELETE (append :id)
    String delete_category_route               = globalBackendRoute + "/api/delete-category/";   // + {id}
}
