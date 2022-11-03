class Solution {

    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> store = new HashMap<>();
        for (String s : arr) {
            store.put(s, store.getOrDefault(s, 0) + 1);
        }
        for (String s : arr) {
            if (store.get(s) == 1) k--;
            if(k==0) return s;
        }

        return "";
    }
}
