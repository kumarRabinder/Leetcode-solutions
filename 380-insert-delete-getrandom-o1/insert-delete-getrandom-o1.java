class RandomizedSet {
    HashMap<Integer, Integer> map;

    ArrayList<Integer> list;

    Random random;
    public RandomizedSet() {
        map = new HashMap<>();

        list = new ArrayList<>();

        random = new Random();

    }
    
    
    public boolean insert(int val) {
        if (map.containsKey(val)) {

            return false;

        }

        // Add at the end

        map.put(val, list.size());

        list.add(val);

        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) {

            return false;

        }

        int index = map.get(val);

        // Get last element

        int lastElement = list.get(list.size() - 1);

        // Put last element at val's position

        list.set(index, lastElement);

        // Update last element's index

        map.put(lastElement, index);

        // Remove last element

        list.remove(list.size() - 1);

        // Remove val from map

        map.remove(val);

        return true;
    }
    
    public int getRandom() {
         int index = random.nextInt(list.size());

        return list.get(index);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */