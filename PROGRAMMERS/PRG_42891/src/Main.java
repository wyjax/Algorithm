import java.sql.Time;
import java.util.*;

class Solution {
    public int solution(int[] food_times, long k) {
        int size = food_times.length;
        ArrayList<Food> food = new ArrayList<>();

        for(int i = 0; i < size; i ++){
            food.add(new Food(food_times[i], i + 1));
        }
        food.sort(CompTime);

        int pretime = 0;
        for(int i = 0; i < size; i++){
            long subTime = food.get(i).time - pretime;

            if(subTime != 0){
                long spend = subTime * (size - i);
                if(spend <= k){
                    k -= spend;
                    pretime = food.get(i).time;
                    food.get(i).time = -1;
                }else{
                    k %= (size - i);
                    food.subList(i,food_times.length).sort(CompIdx);
                    return food.get(i+(int)k).idx;
                }
            }
        }
        return -1;
    }

    class Food {
        int time;
        int idx;
        Food(int time, int idx){
            this.time = time;
            this.idx = idx;
        }
    }
    Comparator<Food> CompTime = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.time - b.time;
        }
    };

    Comparator<Food> CompIdx = new Comparator<Food>(){
        public int compare(Food a, Food b){
            return a.idx - b.idx;
        }
    };
}