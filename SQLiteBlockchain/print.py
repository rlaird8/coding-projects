import sqlite3
from cryptography.fernet import Fernet
import hashlib

# Load the encryption key (ensure it matches the key used for encryption)
key = b'pD0b1W1vinjb1LK_H5Uk7WoQipbUhgi7jpkqwFWSDAw='
cipher = Fernet(key)

def print_blockchain_structure():
    conn = sqlite3.connect('ryanDB.db')
    cursor = conn.cursor()

    # Retrieve all records from the blockchain table
    cursor.execute("SELECT ID, EncryptedData, CurrentHash, PreviousHash FROM BlockchainTable")
    rows = cursor.fetchall()

    print("Test Case 1: Print Encrypted Blockchain Data")
    print("=" * 80)
    print(f"{'ID':<5} {'EncryptedData':<80} {'CurrentHash':<64} {'PreviousHash':<64}")
    print("=" * 80)
    for row in rows:
        row_id, encrypted_data, current_hash, previous_hash = row
        print(f"{row_id:<5} {str(encrypted_data):<80} {current_hash:<64} {previous_hash:<64}")
    
    conn.close()
    print("\n")

def verify_hash_chaining():
    # Connect to SQLite DB
    conn = sqlite3.connect('ryanDB.db')
    cursor = conn.cursor()
    
    # Fetch data from the blockchain table
    cursor.execute("SELECT ID, EncryptedData, CurrentHash, PreviousHash FROM BlockchainTable")
    rows = cursor.fetchall()
    
    print("Test Case 2: Detect Tampering After Data Modification")
    print("="*50)
    
    previous_hash = "0"
    is_chain_valid = True
    
    for row in rows:
        row_id, encrypted_data, current_hash, previous_hash_stored = row
        
        # Recalculate the current hash
        hash_input = encrypted_data + previous_hash.encode()  # Convert previous_hash to bytes
        recalculated_hash = hashlib.sha256(hash_input).hexdigest()
        
        # Check if recalculated hash matches the stored current hash
        if recalculated_hash == current_hash:
            print(f"Row {row_id}: Hash is valid")
        else:
            print(f"Row {row_id}: Hash is INVALID")
            is_chain_valid = False
        
        # Update the previous hash for the next row
        previous_hash = current_hash
    
    # Close the connection
    conn.close()
    return is_chain_valid


def test_tampering_detection():
    # Tamper with a row in BlockchainTable
    conn = sqlite3.connect('ryanDB.db')
    cursor = conn.cursor()
    tampered_data = b'Tampered data'
    row_id_to_tamper = 2
    cursor.execute("UPDATE BlockchainTable SET EncryptedData = ? WHERE ID = ?", (tampered_data, row_id_to_tamper))
    conn.commit()
    


# Run all test cases
print_blockchain_structure()
verify_hash_chaining()
test_tampering_detection()
