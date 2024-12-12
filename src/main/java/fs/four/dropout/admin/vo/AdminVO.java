package fs.four.dropout.admin.vo;

import org.springframework.stereotype.Component;

@Component("adminVO")
public class AdminVO {

    private Number adm_number;

    //검색필터
    private String type;
    private String keyword;

    public AdminVO() {

    }

    public Number getAdm_number() {
        return adm_number;
    }

    public void setAdm_number(Number adm_number) {
        this.adm_number = adm_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
