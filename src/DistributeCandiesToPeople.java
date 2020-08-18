public class DistributeCandiesToPeople {
    //V1: "Brute force"
    //Runtime: 1 ms
    //Memory usage: 36.7 MB
    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int index = 0;

        while (candies > 0) {
            //Asking for more than we have
            if ((index + 1) >= candies) {
                res[index % num_people] += candies;
                candies = 0;
                //break;
            } else {
                res[index % num_people] += (index + 1);
                candies -= (index + 1);

                index++;
            }
        }

        return res;
    }
}
