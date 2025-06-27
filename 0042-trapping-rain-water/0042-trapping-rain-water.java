class Solution {
    public int trap(int[] height) {
        int ans = 0;
        int st = 1;
        int en = height.length - 2;
        int lm = height[0];
        int rm = height[en + 1];
        // slope approach (if else ("<") la two pointers moving means they will intersect at greatest element)
        // athaavathu inga max(element) somewhere in the middle nu we already know it by the 2p approach
        // ipo left pointer oru certain position la iruku nu vachupom
        // now antha left pointer athuku munnadi varaiyum traverse panni vantha max than 2nd max of(current pos elemnt)
        // why because nu keta already the max is in middle and namma atha traverse panna matom as per loop cond
        // and hence previous or next val vachu sub panni answer la add panikalaam
        while (st <= en) {
            lm = Math.max(height[st], lm);
            rm = Math.max(height[en], rm);
            ans += lm <= rm ? (lm - height[st++]) : (rm - height[en--]);
        }
        return ans;
    }
}