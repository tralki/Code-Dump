

CREATE PROCEDURE `addAvailability`(
  IN p_idHotel INT,
  IN p_date DATE
)
BEGIN
  #variables
  DECLARE v_done INT DEFAULT FALSE;
  DECLARE v_idRoom INT;
  DECLARE v_maxAvailable INT;
  DECLARE v_price DECIMAL(10, 2);
  
  #cursors
  DECLARE cursorForRoom CURSOR FOR 
  SELECT 
    idRoom,
    maxAvailable,
    price
  FROM 
    Room
  WHERE
    idHotel = p_idHotel;
  
  #handlers
  DECLARE CONTINUE HANDLER FOR NOT FOUND SET v_done = TRUE;
  DECLARE EXIT HANDLER FOR SQLEXCEPTION, SQLWARNING
  BEGIN
    ROLLBACK;
    RESIGNAL;
  END;  
  
  IF NOT EXISTS(SELECT * FROM Room WHERE idHotel = p_idHotel) THEN
    SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'No Rooms';
  END IF;
  
  OPEN cursorForRoom;  
  START TRANSACTION;
  
  read_loop: LOOP
    FETCH cursorForRoom INTO v_idRoom, v_maxAvailable, v_price;
    IF v_done THEN
      LEAVE read_loop;
    END IF;
    
    INSERT INTO 
      Availability
    SET
      idAvailability = NULL,
      idRoom = v_idRoom,
      numberAvailable = v_maxAvailable,
      price = v_price,
      date = p_date;
  END LOOP;
  
  COMMIT; 
  CLOSE cursorForRoom;
END

