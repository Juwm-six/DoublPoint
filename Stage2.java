package a.k;

/**
 * 基于滑动窗口思想实现：查找给定字符串中重复子串并替换
 */
public class Stage2 {

    public static void main(String[] args) {
        String source = "aabcccbbadeeeewf";
        System.out.println(source);
        char[] strArr = source.toCharArray();
        int indexLeft = 0;
        int indexRight = 0;
        while (true) {
            // 确定是否有重复子串
            if (strArr[indexLeft] != strArr[++indexRight]) {
                if (indexRight == (strArr.length - 1)) {
                    // 右指针移动到字符串尾部，可以确定没有重复子串，退出循环
                    break;
                }
                indexLeft = indexRight;
                continue;
            }
            // 确定有重复子串，复用上面的指针下标，但右指针需要减一
            --indexRight;
            // 统计重复的个数
            int count = 1;
            while (indexRight < (strArr.length - 1)) {
                if (strArr[indexLeft] == strArr[++indexRight]) {
                    // 字符相等，则右指针右移
                    count += 1;
                    continue;
                }
                // 相邻位置不等，左指针右移1
                if (count == 1) {
                    indexLeft = indexRight;
                    continue;
                }
                // 替换重复子串
                source = replace(source, indexRight, count);
                // 用替换后的字符串继续往后遍历
                strArr = source.toCharArray();
                // 重新计算位置
                indexRight = indexRight - count + 1;
                indexLeft = indexRight;
                count = 1;
            }
            // 重置下标
            indexLeft = 0;
            indexRight = 0;
        }
    }

    // 删除重复的子串
    public static String replace(String source, int indexRight, int count) {
        // 计算出左指针下标
        int indexLeft = indexRight - count;
        // 取出左指针下标上了字母
        char character = source.charAt(indexLeft);
        if ('a' != character) {
            // 非字母a，则替换成它前面那个字母
            --character;
        }
        String newString = source.substring(0, indexLeft) + character + source.substring(indexRight);
        System.out.println(newString);
        return newString;
    }
}
