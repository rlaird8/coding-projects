import sqlite3
import hashlib

# Function to modify a row in the BlockchainTable
def modify_row(row_id, new_encrypted_data):
    conn = sqlite3.connect('ryanDB.db')
    cursor = conn.cursor()

    # Update the row with new (tampered) encrypted data
    cursor.execute("UPDATE BlockchainTable SET EncryptedData = ? WHERE ID = ?", (new_encrypted_data, row_id))

    conn.commit()
    conn.close()
    print(f"Row {row_id} has been tampered with!")

# Function to verify the integrity of the blockchain
def verify_blockchain():
    conn = sqlite3.connect('ryanDB.db')
    cursor = conn.cursor()

    # Retrieve all records from the blockchain table
    cursor.execute("SELECT ID, EncryptedData, CurrentHash, PreviousHash FROM BlockchainTable")
    rows = cursor.fetchall()

    previous_hash = "0"
    is_chain_valid = True

    for row in rows:
        row_id, encrypted_data, current_hash, previous_hash_stored = row

        # Recalculate the current hash
        recalculated_hash = hashlib.sha256(encrypted_data + previous_hash.encode()).hexdigest()

        if recalculated_hash != current_hash:
            print(f"Data tampered at row {row_id}!")
            is_chain_valid = False
            break

        # Update previous hash
        previous_hash = current_hash

    if is_chain_valid:
        print("Blockchain is valid. No tampering detected.")
    else:
        print("Blockchain integrity is compromised.")

    conn.close()

# Tamper with a specific row (for example, row 2)
row_to_modify = 2
tampered_data = b'This is tampered data'  # Replace with your own tampered data
modify_row(row_to_modify, tampered_data)

# Verify the blockchain after tampering
verify_blockchain()
