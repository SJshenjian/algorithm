import java.util.*;

/**
 * 相同字母异序词
 *
 * @author Jian Shen
 * @version V1.0.0
 * @date 2019/07/29
 */
public class Anagram {

    /**
     * Given an array of strings, return all groups of strings that are anagrams.
     * Note: All inputs will be in lower-case.
     *
     * @param strs
     * @return
     */
    public List<String> anagrams(String[] strs) {
        if (strs == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }

        for (String key : map.keySet()) {
            ArrayList<String> list = map.get(key);
            if (list.size() > 1) {
                result.addAll(list);
            }
        }
        return result;
    }

    /**
     * 判断两个字符串是否为同母异序
     * 适用于仅包含26个字母的字符串情况
     * 若包含特殊字符，可采用Arrays.sort()排序比较或HashMap统计计算
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

    private String sort(String origin) {
        char[] array = origin.toCharArray();
        Arrays.sort(array);
        return new String(array);
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

        String[] strs = new String[]{"kiweyjmvcdfdeeerghde", "wedfrghyjkimvcddeeee", "eeeeeew2grggdvdfbdfbfb", "eeeeeedfbfbrggdvdfbw2g", "wrong"};
        List result = anagram.anagrams(strs);
        System.out.println(result);
    }
}
