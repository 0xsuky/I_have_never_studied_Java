class NewsPaperSync {
  String todayNews;
  boolean isTodayNews = false;

  public void setTodayNews(String news) {
    todayNews = news;
    isTodayNews = true;
    synchronized (this) {
      notifyAll();
    }
  }

  public String getTodayNews() {
    if (isTodayNews == false) {
      try {
        synchronized (this) {
          wait();
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    return todayNews;
  }
}

class NewsWriterSync extends Thread {
  NewsPaperSync paper;

  public NewsWriterSync(NewsPaperSync paper) {
    this.paper = paper;
  }

  public void run() {
    paper.setTodayNews("자바의 열기가 뜨겁습니다.");
  }
}

class NewsReaderSync extends Thread {
  NewsPaperSync paper;

  public NewsReaderSync(NewsPaperSync paper) {
    this.paper = paper;
  }

  public void run() {
    System.out.println("오늘의 뉴스 : " + paper.getTodayNews());
  }
}

public class SyncNewsPaper {
  public static void main(String[] args) {
    NewsPaperSync paper = new NewsPaperSync();
    NewsReaderSync reader1 = new NewsReaderSync(paper);
    NewsReaderSync reader2 = new NewsReaderSync(paper);
    NewsWriterSync writer = new NewsWriterSync(paper);

    try {
      reader1.start();
      reader2.start();

      Thread.sleep(1000);
      writer.start();

      reader1.join();
      reader2.join();
      writer.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
