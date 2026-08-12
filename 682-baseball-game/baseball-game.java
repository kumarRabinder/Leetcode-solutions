class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st= new Stack<>();
        int score = 0;
        for(int i=0; i<operations.length; i++){
            if(operations[i].equals("+")){
                int sum=st.peek() + st.get(st.size() - 2);
                st.push(sum);
            }else if(operations[i].equals("D")){
                st.push(st.peek()*2);
            }else if(operations[i].equals("C")){
                st.pop();
            }else{
                st.push(Integer.parseInt(operations[i]));
            }
        }
        for(int sta : st){
            score += sta;
        }

        return score;
    }
}