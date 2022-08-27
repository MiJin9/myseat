package com.mycompany.myseat.domain;

public class PageHandler {
    private int totalCnt; //총 게시물 개수
    private int totalPage; //총 페이지 개수
    private int page; //현재 페이지
    private int pageSize; //한 페이지에 나올 게시물 개수
    private int naviSize = 10; //페이지 내비게이션의 크기
    private int beginPage; //시작페이지
    private int endPage; //끝페이지
    private boolean showPre;
    private boolean showNext;

    public PageHandler(){}

    public PageHandler(int totalCnt, int page){
        this(totalCnt, page, 10);
    }

    public PageHandler(int totalCnt, int page, int pageSize){
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil(totalCnt / pageSize);
        beginPage = (page-1)/naviSize*naviSize + 1;
        endPage = Math.min(beginPage+naviSize-1, totalPage);
        showPre = beginPage != 1;
        showNext = endPage != totalPage;
    }

    void print(){
        System.out.println("page = " + page);
        System.out.print(showPre ? "[PREV] " : "");
        for(int i=beginPage; i<=endPage; i++){
            System.out.print(i + " ");
        }
        System.out.println(showNext ? " [NEXT]" : "");
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPre() {
        return showPre;
    }

    public void setShowPre(boolean showPre) {
        this.showPre = showPre;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", totalPage=" + totalPage +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", naviSize=" + naviSize +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPre=" + showPre +
                ", showNext=" + showNext +
                '}';
    }
}
