package java6.newfeatures._1_new_utils._3_cookie_manager;

import java.net.*;
import java.util.List;

// 新的cookie管理包
public class _1_CookieManager {
    public static void main(String[] args) {
        // 创建一个默认的 CookieManager
        CookieManager manager = new CookieManager();

        // 将规则改掉，接受所有的 Cookie
        manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);

        // 保存这个定制的 CookieManager
        CookieHandler.setDefault(manager);

        // 接受 HTTP 请求的时候，得到和保存新的 Cookie
        HttpCookie cookie = new HttpCookie("...(name)...","...(value)...");
        URI uri = null;
        manager.getCookieStore().add(uri, cookie);

        // 使用 Cookie 的时候：
        // 取出 CookieStore
        CookieStore store = manager.getCookieStore();

        // 得到所有的 URI
        List<URI> uris = store.getURIs();
        for (URI u : uris) {
            // 筛选需要的 URI
            // 得到属于这个 URI 的所有 Cookie
            List<HttpCookie> cookies = store.get(u);
            for (HttpCookie c : cookies) {
                // 取出了 Cookie
            }
        }

        // 或者，取出这个 CookieStore 里面的全部 Cookie
        // 过期的 Cookie 将会被自动删除
        List<HttpCookie> cookies = store.getCookies();
        for (HttpCookie c : cookies) {
            // 取出了 Cookie
        }
    }
}
