package doubleAss.pijama.common.util;

import java.util.ArrayList;
import java.util.List;

public class Pagination {
    
    private int firstPage;
    
    private int lastPage;
    
    private int pageNext;
    
    private int pagePre;
    
    private int begin;
    
    private int end;
    
    public int getFirstPage() {
        return firstPage;
    }

    public int getLastPage() {
        return lastPage;
    }

    public int getPageNext() {
        return pageNext;
    }
    
    public int getPagePre() {
        return pagePre;
    }
    
    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    } 
    
    // lấy ra danh sách trang
    @Deprecated
    public List<Integer> listPage(int currentPage, long totalItems, int sizePage, int totalPageResult) {
        
        int totalPages = (int) (totalItems/sizePage);
        
        if(totalPages == 0) {
            totalPages = 1;
        }
        
        totalPageResult -= 1;
        
        int max = totalPageResult + 1;
        int min = max - totalPageResult;
        
        this.firstPage = 1;
        this.lastPage = totalPages;
        this.pageNext = currentPage + 1;
        this.pagePre = currentPage - 1;
        
        if(pageNext > totalPages) {
            pageNext = 0;
        }
        
        if(pagePre < firstPage) {
            pagePre = 0;
        }
        
        List<Integer> listPage = new ArrayList<>();
        
        if(currentPage >= max){
            max = currentPage + 2;
            min = max - totalPageResult;
        }
        
        if(max >= totalPages){
            max = totalPages;
            min = max - totalPageResult;
            if(min <= 0){
                min = 1;
            }
        }
        
        for(int i = min; i<=max; i++) {
            listPage.add(i);
        }
        return listPage;  
     }

    //Setup phân trang
    public Pagination(int currentPage, long totalItems, int sizePage, int totalPageResult) {
        
        int totalPages = (int) (totalItems/sizePage);
        
        if(totalPages == 0) {
            totalPages = 1;
        }
        
        totalPageResult -= 1;
        
        int max = totalPageResult + 1;
        int min = max - totalPageResult;
        
        if(currentPage >= max){
            max = currentPage + 2;
            min = max - totalPageResult;
        }
        
        if(max >= totalPages){
            max = totalPages;
            min = max - totalPageResult;
            if(min <= 0){
                min = 1;
            }
        }
        
        this.firstPage = 1;
        this.lastPage = totalPages;
        this.pageNext = currentPage + 1;
        this.pagePre = currentPage - 1;
        this.begin = min;
        this.end = max;
        
        if(pageNext > totalPages) {
            pageNext = 0;
        }
        
        if(pagePre < firstPage) {
            pagePre = 0;
        }
    }

}
