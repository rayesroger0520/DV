/*
 * HtmlHelper.java

 * All Rights Reserved.
 * Copyright (c) 2019 FPT University
 *
 */
package util;

/**
 * HtmlHelper <br>
 * 
 * <pre>
 * Store HtmlHelper
 * .generateHyperlink()
 * .pagger()
 * </pre>
 * 
 * @author thinh
 */
public class HtmlHelper {
    public static String generateHyperlink(String href, String innerText) {
        return "<a id=\"paging\" href=\"" + href + "\" >" + innerText + "</a>";
    }

    public static String pagger(int pageIndex,  int totalPage,String page,String search) {
        String result = "";

        for (int i =  1; i < pageIndex; i++) {

            result += generateHyperlink(page+"?page=" + i+"&search=" +search, "    " + i);

        }

        result += "<span class='pageindex'>" + "    " + pageIndex + "    " + "</span>";

        for (int i = pageIndex + 1; i <=  totalPage; i++) {
            result += generateHyperlink(page+"?page=" + i+"&search=" +search, "    " + i);
        }

        return result;
    }
}
