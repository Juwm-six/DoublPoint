/**
 * 基于滑动窗口思想实现：查找给定字符串中重复子串并替换
 */
public class Stage1 {
    public static void main(String[] args) {
        String source = "aabcccbbadeeeewf";
        System.out.println(source);
        char[] strArr = source.toCharArray();
        while (true) {
            int indexLeft = 0;
            int indexRight = 0;
            // 记录字符重复次数
            int count = 1;
            int recordBigCount = 1;
            // 记录最长重复子串的右指针下标
            int recordIndexRight = 0;
            int length = strArr.length - 1;
            while (indexRight < length) {
                if (strArr[indexLeft] == strArr[++indexRight]) {
                    // 字符重复的次数
                    count += 1;
                    continue;
                }
                indexLeft = indexRight;
                // 只记录最长的子串
                if (count > recordBigCount) {
                    recordIndexRight = indexRight;
                    recordBigCount = count;
                }
                // 重置统计，进入下一次寻找
                count = 1;
            }
            // 找不到重复的子串，退出
            if (recordBigCount == 1) {
                return;
            }
            // 干掉子串
            source = removeRepeatSubString(source, recordIndexRight - recordBigCount, recordIndexRight - 1);
            // 重新整理字符
            strArr = source.toCharArray();
        }
    }

    // 将重复的子串替换成它前面那个字母
    public static String removeRepeatSubString(String source, int repeatStartIndex, int repeatEndIndex) {
        String startStr = source.substring(0, repeatStartIndex);
        String endStr = source.substring(repeatEndIndex + 1);
        String value = startStr + endStr;
        System.out.println(value);
        return value;
    }
}
