class Bank {
    // program for a banking system
    Map<Integer,Long> map  =  new HashMap<>();
    public Bank(long[] balance) {
        for(int i=0;i<balance.length;i++){
            map.put(i+1,balance[i]);
        }
    }
    
    public boolean transfer(int acc1, int acc2, long money) {
        if(!(map.containsKey(acc1))||!(map.containsKey(acc2))||(map.get(acc1)<money)){
            return false;
        }
        map.put(acc2,map.get(acc2)+money);
        map.put(acc1,map.get(acc1)-money);
        return true;
    }
    
    public boolean deposit(int acc, long money) {
        if(!map.containsKey(acc)){
            return false;
        }
        map.put(acc,map.get(acc)+money);
        return true;
    }
    
    public boolean withdraw(int acc, long money) {
        if(!map.containsKey(acc)||money>map.get(acc)){
            return false;
        }
        map.put(acc,map.get(acc)-money);
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */