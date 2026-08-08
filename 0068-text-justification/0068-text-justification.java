class Solution {
    public List<String> fullJustify(String[] arr, int k) {
        int l=0, n=arr.length;
        int wordcnt=0, currlen=0;
        List<String> ans=new ArrayList<>();
        for(int r=0;r<n;r++){
            String word=arr[r];
            int len=word.length();
            if(currlen + (wordcnt>0?1:0) + len > k){
                StringBuilder sb=new StringBuilder();
                int space=(wordcnt==1)?(k-currlen):((k-currlen)/(wordcnt-1))+1;
                int spaceRem=(wordcnt==1)?0:(k-currlen)%(wordcnt-1);
                while(l<r){
                    if(sb.length()>0) {
                        for(int s=0;s<space;s++) {
                            sb.append(" ");
                            if(spaceRem>0) {
                                sb.append(" ");
                                spaceRem-=1;
                            }
                        }
                    }
                    sb.append(arr[l++]);
                    if(wordcnt==1) for(int s=0;s<space;s++) sb.append(" ");
                }
                ans.add(sb.toString());
                currlen=len;
                wordcnt=1;
            }else{
                if(currlen>0) currlen+=1;
                currlen+=len;
                wordcnt++;
            }
        }
        if(l<n){
            StringBuilder sb=new StringBuilder();
            while(l<n){
                if(sb.length()>0) sb.append(" ");
                sb.append(arr[l++]);
            }
            int leftspace=k-sb.length();
            for(int s=0;s<leftspace;s++) sb.append(" ");
            ans.add(sb.toString());
        }
        return ans;
        }
    }