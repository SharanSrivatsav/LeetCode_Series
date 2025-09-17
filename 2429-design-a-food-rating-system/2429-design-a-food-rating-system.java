class Value {
    String food;
    String cuisine;
    int rating;

    Value(String food, String cuisine, int rating) {
        this.food = food;
        this.cuisine = cuisine;
        this.rating = rating;
    }
}

class Entry {
    String food;
    int rating;
    Entry(String food, int rating) {
        this.food = food;
        this.rating = rating;
    }
}

class FoodRatings {
    Map<String, Value> map;
    Map<String, PriorityQueue<Entry>> cus;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        int n = foods.length;
        map = new HashMap<>();
        cus = new HashMap<>();

        for (int i = 0; i < n; i++) {
            Value v = new Value(foods[i], cuisines[i], ratings[i]);
            map.put(foods[i], v);

            cus.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>(
                (e1, e2) -> e1.rating == e2.rating ? e1.food.compareTo(e2.food) : e2.rating - e1.rating
            ));
            cus.get(cuisines[i]).add(new Entry(foods[i], ratings[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        Value v = map.get(food);
        v.rating = newRating;
        cus.get(v.cuisine).add(new Entry(food, newRating));
    }

    public String highestRated(String cuisine) {
        PriorityQueue<Entry> pq = cus.get(cuisine);

        while (true) {
            Entry top = pq.peek();
            if (top == null) return "";
            if (map.get(top.food).rating == top.rating) {
                return top.food;
            }
            pq.poll();
        }
    }
}
