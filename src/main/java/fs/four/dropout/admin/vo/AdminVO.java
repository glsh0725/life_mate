package fs.four.dropout.admin.vo;

import org.springframework.stereotype.Component;

@Component("adminVO")
public class AdminVO {

    private Number adm_number;
    private String usr_id;

    public AdminVO() {

    }

    public Number getAdm_number() {
        return adm_number;
    }

    public void setAdm_number(Number adm_number) {
        this.adm_number = adm_number;
    }

    public String getUsr_id() {
        return usr_id;
    }

    public void setUsr_id(String usr_id) {
        this.usr_id = usr_id;
    }
}
