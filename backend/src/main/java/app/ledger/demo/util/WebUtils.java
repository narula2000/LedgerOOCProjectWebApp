package app.ledger.demo.util;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Collection;

public class WebUtils {

    public static String toString(User user) {
        StringBuilder sb = new StringBuilder();

        sb.append("UserName:").append(user.getUsername());

        Collection<GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
    public static boolean isValidDateRange(Date startDate, Date endDate) {
        // false if either value is null
        if (startDate == null || endDate == null) { return false; }

        // true if endDate after startDate
        return endDate.after(startDate);
    }
}

