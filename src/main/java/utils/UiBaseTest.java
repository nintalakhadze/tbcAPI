//package utils;
//
//import com.microsoft.playwright.*;
//
//import org.testng.annotations.BeforeClass;
//
//import java.util.List;
//
//public class UiBaseTest {
//    protected Playwright playwright;
//    protected Browser browser;
//    protected BrowserContext context;
//    protected Page page;
//
//    @BeforeClass
//    public void setUp(){
//        playwright = Playwright.create();
//        browser = playwright.chromium().launch(
//                new BrowserType.LaunchOptions()
//                        .setHeadless(false)
//                        .setArgs(List.of("--start-maximized"))
//                        .setSlowMo(1000)
//        );
//        context = browser.newContext(
//                new Browser.NewContextOptions().setViewportSize(null)
//        );
//        page = context.newPage();
////        page.navigate(
////                Constants.BASE_URL,
////                new Page.NavigateOptions()
////                        .setTimeout(50_000)
////                        .setWaitUntil(WaitUntilState.LOAD)
////        );
//    }
////    public Page getPage(){return page;}
//}
