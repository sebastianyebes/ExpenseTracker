import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css";

export const CustomDatePickerTheme = ({selectDate, setSelectDate}) => {
    return (
        <div>
            <DatePicker showIcon selected={selectDate} onChange={(date) => setSelectDate(date)} dateFormat="MM/dd/yyyy" placeholderText='Select a date'
                className='border bg-amber-50 rounded-md w-36 px-5 py-1 text-gray-900  outline-none'/>
        </div>
    )
}
