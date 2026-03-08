import './App.css'
import api from './Helper/api.js'
import { CustomDatePickerTheme } from './Components/CustomDatePickerTheme'
import { useState } from 'react'

const App = () => {
  const[title, setTitle] = useState('');
  const[amount, setAmount] = useState('');
  const[category, setCategory] = useState('food');
  const[selectDate, setSelectDate] = useState(new Date());

  const handleSubmit = async (e) => {
    e.preventDefault();

    const expenseData = {
      title,
      amount,
      category,
      date: selectDate
    }
    
    try {
      if(!title || !amount){
        alert('Please fill in all required fields.');
        return;
      }

      const response = await api.post('/expenses', expenseData);
      console.log('Expense added:', response.data);

      setTitle('');
      setAmount('');
      setCategory('food');
      setSelectDate(new Date());
    }
    catch(error){
      console.error('Error adding expense:', error);
      alert('Failed to add expense. Please try again.');
    }
  }

  return (
    <main>
      <div className='text-center p-5'>
        <header className='font-bold text-2xl'>Expense Tracker</header>
      </div>
      <form className='flex justify-center gap-2.5' onSubmit={handleSubmit}>
        <input type="text" placeholder='Expense Name' className='border bg-amber-50 text-gray-900 rounded-md w-44 px-3 py-1 outline-none' value={title} onChange={(e) => setTitle(e.target.value)}/>
        <div className="relative w-44">
          <span className="absolute left-3 bottom-2 text-gray-900">
            ₱
          </span>
          <input
            type="number"
            placeholder="Amount"
            className="border bg-amber-50 rounded-md w-full pl-8 pr-2 py-1.5 text-gray-900 outline-none"
            value={amount}
            onChange={(e) => {setAmount(e.target.value)}}
          />
        </div>        
        <select name="categoryDropdown" className='border bg-amber-50 text-gray-900 rounded-md w-36 px-3 py-1 outline-none' value={category} onChange={(e) => setCategory(e.target.value)}>
            <option value="food" >Food</option>
            <option value="transportation">Transportation</option>
            <option value="entertainment">Entertainment</option>
            <option value="utilities">Utilities</option>
            <option value="other">Other</option>
        </select>
        <CustomDatePickerTheme selectDate={selectDate} setSelectDate={setSelectDate} />
        <button type='submit' className='bg-green-700 hover:bg-green-800 active:bg-green-900 rounded-md w-30 px-2 py-1 text-white outline-none cursor-pointer text-sm '>
          Add Expense
        </button>
      </form>
    </main>
  )
}

export default App
