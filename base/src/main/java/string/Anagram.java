/**
 * 相同字母异序词
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/07/29
 */
public class Anagram {

    /**
     * 判断两个字符串是否为同母异序
     * 适用于仅包含26个字母的字符串情况
     * 若包含特殊字符，可采用HashMap统计计算
     *
     * @param first
     * @param second
     * @return
     */
    public boolean isAnagram(String first, String second) {
        if (first == null && second == null) {
            return true;
        }
        if (first == null || second == null) {
            return false;
        }

        int[] array = new int[26];
        for (char temp : first.toCharArray()) {
            array[temp - 'a']++;
        }
        for (char temp : second.toCharArray()) {
            array[temp - 'a']--;
        }
        for (int temp : array) {
            if (temp != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Anagram anagram = new Anagram();
        String first = "kiweyjmvcdfdeeerghde";
        String second = "wedfrghyjkimvcddeeee";
        String three = "wegegegdbgbdghg";
        boolean isAnagram = anagram.isAnagram(first, second);
        System.out.println(isAnagram);

        boolean notIsAnagram = anagram.isAnagram(first, three);
        System.out.println(notIsAnagram);
    }
}
