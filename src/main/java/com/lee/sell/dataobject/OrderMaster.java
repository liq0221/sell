package com.lee.sell.dataobject;
import com.lee.sell.enums.OrderStatusEnum;
import com.lee.sell.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * -实体类
 * @author lee
 *
 */
@Entity
@Data
@DynamicUpdate
public class OrderMaster {

	@Id
	private String orderId;
	
	private String buyerName;

	private String buyerPhone;

	private String buyerAddress;

	private String buyerOpenid;

	private BigDecimal orderAmount;

	private Integer orderStatus= OrderStatusEnum.NEW.getCode();

	private Integer payStatus= PayStatusEnum.WAIT.getCode();

	private Date createTime;

	private Date updateTime;


	
}
