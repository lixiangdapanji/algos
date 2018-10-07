import java.util.ArrayList;
import java.util.List;

public class _0068TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int index = 0;
        while (index < words.length) {
            //count：该行所有单词累计总长度
            int count = words[index].length();
            //last:该行最后一个词的index
            int last = index + 1;
            while (last < words.length) {
                //out of bound
                if (words[last].length() + count + 1 > maxWidth) break;
                //plus one for the space, if its a perfect fit it will fit
                count += 1 + words[last].length();
                last++;
            }
            StringBuilder sb = new StringBuilder();
            //append该行第一个单词
            sb.append(words[index]);
            //这一行共几个词语：diff 个：从index到last-1
            int diff = last - 1 - index;
            // if last line or number of words in the line is 1, left-justified
            //最后一行：每个单词中间一个空格， 剩余补上空白
            if (last == words.length || diff == 0) {
                //index 从第二个单词开始append 第一个已经append过了
                for (int i = index+1; i < last; i++) {
                    sb.append(" ");
                    sb.append(words[i]);
                }
                for (int i = sb.length(); i < maxWidth; i++) {
                    sb.append(" ");
                }
            } else {
                //不是最后一行：middle justified
                //space的个数：（长度-累计单词总长度）/单词个数
                int spaces = (maxWidth - count) / diff;
                //多余的需要加在前面的space
                int r = (maxWidth - count) % diff;
                //index 从第二个单词开始append 第一个已经append过了
                for (int i = index + 1; i < last; i++) {
                    for(int k=spaces; k > 0; k--) {
                        sb.append(" ");
                    }
                    if(r > 0) {
                        sb.append(" ");
                        r--;
                    }
                    sb.append(" ");
                    sb.append(words[i]);
                }
            }
            result.add(sb.toString());
            index = last;
        }
        return result;
    }
}
