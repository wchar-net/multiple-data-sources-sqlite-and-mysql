package net.wchar.sample.mds.model.po;

import lombok.Data;
import lombok.ToString;


/**
 * Account Po
 *
 * @author wchar.net
 */
@ToString
@Data
public class AccountPo {
    private Long accountId;
    private String accountName;
    private Integer isDelete;
}
