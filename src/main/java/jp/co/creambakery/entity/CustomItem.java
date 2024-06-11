package jp.co.creambakery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

/**
 * custom_item_テーブルのエンティティ
 * CREATE TABLE custom_item (
 *	item INTEGER PRIMARY KEY REFERENCES item(id) NOT NULL,
 *	creator INTEGER REFERENCES customer(id) NOT NULL,
 *	is_public NUMBER(1) DEFAULT 0
 * );
 */

@Entity
@Table(name = "custom_item")
public class CustomItem {
    
}
