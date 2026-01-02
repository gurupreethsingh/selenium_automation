package routes;

public class BlogRoutes 
{
    String globalBackendRoute = "http://localhost:3010";

    // CREATE
    String post_add_blog_route        = globalBackendRoute + "/api/add-blog";

    // READ
    String get_fetch_all_blogs_route  = globalBackendRoute + "/api/all-blogs";

    // For this, append the Blog ID where you use it:
    String get_single_blog_route      = globalBackendRoute + "/api/single-blogs/"; // + {id}
}
