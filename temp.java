
  public String getNumbering(HashMap map, Object... parameters) {

    link = link + "?";
    for (Object param: parameters) {
      link += param +"=" + (String) map.get(param);
    }

    int totalPage = (this.total - 1) / this.pageSize + 1;
    int prev10 = (int)Math.floor((double)(this.cpage - 1) / 10.0D) * 10;
    int next10 = prev10 + 11;
    StringBuffer sbuf = new StringBuffer();
    if(prev10 > 0) {
      sbuf.append("<a href=\"").append(this.getLink()).append("&&cpage=1").append("\">top<<</a>\n");
      sbuf.append("<a href=\"").append(this.getLink()).append("&&cpage=").append(prev10).append("\">이전10개</a>\n");
    }

    for(int i = 1 + prev10; i < next10 && i <= totalPage; ++i) {
      if(i == this.cpage) {
        sbuf.append("<b>[").append(i).append("]</b> ");
      } else {
        sbuf.append(" <a href=\"").append(this.getLink()).append("&&cpage=").append(i).append("\">[").append(i).append("]</a> ");
      }
    }

    if(totalPage >= next10) {
      sbuf.append("<a href=\"").append(this.getLink()).append("&&cpage=").append(next10).append("\">다음10개</a>\n");
      sbuf.append("<a href=\"").append(this.getLink()).append("&&cpage=").append(totalPage).append("\">>>bottom</a>\n");
    }

    return sbuf.toString() == ""?"기록하신 내용이 없습니다.":sbuf.toString();
  }
