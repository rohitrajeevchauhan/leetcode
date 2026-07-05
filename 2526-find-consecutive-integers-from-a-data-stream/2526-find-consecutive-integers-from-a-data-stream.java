class DataStream {
    int value;
    int k;
    int count;
    public DataStream(int value, int k) {
        this.value = value;
        this.k = k;
        count = 0;
    }
    public boolean consec(int num) {
        if(num == value){
            count++;
        }else{
            count = 0;
            return false;
        }
        if(count == k){
            count--;
            return true;
        }
        return false;
    }
}