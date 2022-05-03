package s98;
/* https://leetcode-cn.com/problems/reorder-data-in-log-files/ */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Map<String, MetaData> ms = new HashMap<>();
        Arrays.sort(logs, (a, b)->{
            MetaData ma, mb;
            if ( ms.containsKey(a)) ma = ms.get(a);
            else {
                ma = new MetaData(a);
                ms.put(a, ma);
            }
            if ( ms.containsKey(b)) mb = ms.get(b);
            else {
                mb = new MetaData(b);
                ms.put(b, mb);
            }
            if (ma.isNum ^ mb.isNum) return ma.isNum ? 1 : -1;
            if (ma.isNum) return 0;
            for (int i = 1; i < ma.content.length && i < mb.content.length; i++) {
                int res = ma.content[i].compareTo(mb.content[i]);
                if (res != 0) return res;
            }
            if (ma.content.length != mb.content.length) return ma.content.length - mb.content.length;

            return ma.id.compareTo(mb.id);
        });

        return logs;
    }

    static class MetaData {
        String id;
        String[] content;
        boolean isNum;

        MetaData(String log) {
            String[] patterns = log.split(" ");
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i < patterns.length; i++){
                sb.append(patterns[i]);
            }
            id = patterns[0];
            content = patterns;
            isNum = true;
            for (int i = 0; i < patterns[1].length(); i++) {
                char c = patterns[1].charAt(i);
                if (c < '0' || c > '9') {
                    isNum = false;
                    break;
                }
            }
        }

    }
}
