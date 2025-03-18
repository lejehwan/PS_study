class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int aSize = a.length() - 1;
        int bSize = b.length() - 1;
        int carry = 0;
        
        while (aSize >= 0 || bSize >= 0 || carry > 0) {
            int sum = carry;
            if (aSize >= 0) sum += a.charAt(aSize --) - '0';
            if (bSize >= 0) sum += b.charAt(bSize --) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        return sb.reverse().toString();
    }
}