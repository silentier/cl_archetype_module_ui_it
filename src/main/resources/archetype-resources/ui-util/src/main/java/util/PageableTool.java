package ${package}.util;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class PageableTool {

    public static String getQuery(Pageable pageable) {
        StringBuilder query = new StringBuilder();
        query.append("page=").append(pageable.getPageNumber()).append("&");
        query.append("size=").append(pageable.getPageSize()).append("");

        for (Sort.Order order : pageable.getSort().toList())
        {
            query.append("&").append("sort=").append(order.getProperty()).append(",").append(order.getDirection());
        }

        return query.toString();
    }
}
