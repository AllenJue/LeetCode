class CombinationIterator {
    private List<String> list;
    private int index;
    
    public CombinationIterator(String characters, int combinationLength) {
        list = new ArrayList<>();
        index = 0;
        combinationFinder(new StringBuilder(), characters, combinationLength, 0);
    }
    
    private void combinationFinder(StringBuilder sb, String characters, int combinationLength, int z) {
        if(sb.length() == combinationLength) {
            list.add(sb.toString());
        } else {
            for(int i = z; i < characters.length(); i++) {
                sb.append(characters.charAt(i));
                combinationFinder(sb, characters, combinationLength, i + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    
    public String next() {
        return list.get(index++);
    }
    
    public boolean hasNext() {
        return index < list.size();
    }
}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */