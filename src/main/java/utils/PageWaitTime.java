package utils;

import lombok.Getter;

public enum PageWaitTime {

    WAIT_TIME(8);

     long pageWaitTime;

  PageWaitTime(long pageWaitTime) {
        this.pageWaitTime = pageWaitTime;
    }

    public long getPageWaitTime(){
      return pageWaitTime;
    }

}
