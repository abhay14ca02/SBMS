package com.rajabhay.generator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGenerator implements IdentifierGenerator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6909978480612466573L;

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {
		final String prefix = "ORD_";
		final String[] suffix = new String[1];
		final String query = "SELECT ORDER_ID_SEQ.NEXTVAL FROM DUAL";
		session.doWork(connection -> {
			try (PreparedStatement ps = connection.prepareStatement(query); 
					ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					long seqValue = rs.getLong(1);
					suffix[0] = String.valueOf(seqValue);

				}
			}
		});
		return prefix + suffix[0];
	}

}
