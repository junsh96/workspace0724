import { useState } from "react";

const useBase64FileInput = () => {
    const [file, setFile] = useState(null);
    const [base64, setBase64] = useState("");
    const [preview, setPreview] = useState("");

    const toBase64 = (file) =>
        new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.readAsDataURL(file);
            reader.onload = () => resolve(reader.result);   // ← FIXED!!!
            reader.onerror = (error) => reject(error);
        });

    const onChange = async (e) => {
        const selected = e.target.files?.[0];
        if (!selected) return;

        setFile(selected);

        const base64String = await toBase64(selected);
        setBase64(base64String); // ← 저장용 Base64

        setPreview(URL.createObjectURL(selected)); // ← 화면 표시용
    };

    const reset = () => {
        setFile(null);
        setBase64("");
        setPreview("");
    };

    return { file, base64, preview, onChange, reset };
};

export default useBase64FileInput;